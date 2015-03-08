#include <stdio.h>
#include <string.h>
#include <algorithm>
#define FOR(i,s,t) for(int i=(s); i<(t); i++)
const int maxn = 1000 + 2;

int d2[maxn][maxn], d5[maxn][maxn], a[maxn][maxn], n, u, v;
char dr2[maxn][maxn], dr5[maxn][maxn];
bool flag;

int cal(int x, int p)
{
    if(x == 0)
        return 1;
    int cnt = 0;
    while(x % p == 0)
    {
        cnt ++;
        x /= p;
    }
    return cnt;
}

void DP(int d[][maxn], char dr[][maxn], int p)
{
    FOR(i, 0, n)
        d[0][i] = (i == 0 ? 0 : d[0][i-1]) + cal(a[0][i], p), dr[0][i] = 'R';
    FOR(i, 1, n)
    {
        FOR(j, 0, n)
        {
            if(j == 0)
            {
                d[i][j] = d[i - 1][j] + cal(a[i][j], p);
                dr[i][j] = 'D';
            }
            else
            {
                if(d[i - 1][j] < d[i][j - 1])
                {
                    d[i][j] = d[i - 1][j] + cal(a[i][j], p);
                    dr[i][j] = 'D';
                }
                else
                {
                    d[i][j] = d[i][j - 1] + cal(a[i][j], p);
                    dr[i][j] = 'R';
                }
            }
        }
    }
}

void printway(char dr[][maxn], int x, int y)
{
    if(x == 0 && y == 0)
        return ;
    if(dr[x][y] == 'D')
        printway(dr, x - 1, y);
    else
        printway(dr, x, y - 1);
    putchar(dr[x][y]);
}

void read()
{
    flag = false;
    FOR(i, 0, n)
        FOR(j, 0, n)
        {
            scanf("%d", &a[i][j]);
            if(a[i][j] == 0)
            {
                flag = true;
                u = i, v = j;
            }
        }
}

int main()
{
    while(scanf("%d", &n) == 1)
    {
        read();
        DP(d2, dr2, 2);
        DP(d5, dr5, 5);
        if(flag)
        {
            if(d2[n - 1][n - 1] == 0)
            {
                printf("0\n");
                printway(dr2, n - 1, n - 1);
            }
            else if(d5[n - 1][n - 1] == 0)
            {
                printf("0\n");
                printway(dr5, n - 1, n - 1);
            }
            else
            {
                printf("1\n");
                FOR(i, 0, u) putchar('D');
                FOR(i, 0, n - 1) putchar('R');
                FOR(i, u, n - 1) putchar('D');
            }
        }
        else
        {
            if(d2[n-1][n-1] < d5[n-1][n-1])
            {
                printf("%d\n", d2[n-1][n-1]);
                printway(dr2, n - 1, n - 1);
            }
            else
            {
                printf("%d\n", d5[n-1][n-1]);
                printway(dr5, n - 1, n - 1);
            }
        }
        putchar('\n');
    }
    return 0;
}
