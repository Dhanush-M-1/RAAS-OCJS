/* 2013-08-11 09:01:51.521158 */#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int n,a,b,c,ans;
int main()
{
    scanf("%d%d%d%d",&n,&a,&b,&c);
    ans=0;
    for (int i=0;i<=a;i++)
        if (!(i&1)) 
            for (int j=0;j<=b;j++) {
                int sum=n-i/2-j;
                if (sum<0) continue;
                if (sum&1) continue;
                int k=sum/2;
                if (k>c) continue;
                ans++;
            }
    printf("%d\n",ans);
    return 0;
}
