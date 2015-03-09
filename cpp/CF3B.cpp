#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#include<string>

using namespace std;

#define MAXN 100000+10

struct Node{
    int w,v,index;
} node[MAXN];

int n,m;

int cmp(const Node &p, const Node &q){
  if(p.w != q.w){
    return p.w < q.w;
  }else if(p.w == 1){
    return p.v < q.v;
  }else
    return p.v > q.v;
}

int main(){
  while(~scanf("%d%d", &n, &m)){
    for(int i = 1;i <= n; i++){
      int x, y;
      scanf("%d%d", &x, &y);
      node[i].index = i;
      node[i].v = y;
      x == 1 ? node[i].w = 1 : node[i].w = 2;
    }
    sort(node+1, node+n+1, cmp);
    int MAX = 0, w1 = 0, v1 = 0, MAXi = 1;
    for(int i = 1, j = 1; i <= n; i++){
      w1 += node[i].w;
      v1 += node[i].v;
      while(w1 > m){
        w1 -= node[j].w;
        v1 -= node[j].v;
        j++;
      }
      if(v1 > MAX){
        MAX = v1;
        MAXi=j;
      }
    }
    printf("%d\n", MAX);

    w1 = v1 = 0;
    for(int j = MAXi; j <= n; j++){
      w1 += node[j].w;
      v1 += node[j].v;
      if(w1 > m)
        break;
      j == MAXi ? printf("%d", node[j].index) : printf(" %d", node[j].index);
    }
    puts("");
  }
  return 0;
}
