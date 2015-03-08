#include <math.h>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int n,m,a;
    scanf("%d%d%d",&n,&m,&a);
    printf("%I64d\n",(long long)(ceil(n/double(a))*ceil(m/double(a))));
    
    return 0;
}
