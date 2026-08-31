/**
  * @brief codeforces
  * @author yao
  */
#include <cstdlib>
#include <cstdio>
#include <cctype>
#include <cstring>
#include <utility>
#include <algorithm>
#include <functional>
#include <climits>
#define ft first
#define sd second
#ifdef DBG
#   define dbg_pri(x...) fprintf(stderr,x)
#else
#   define dbg_pri(x...) 0
#   define NDEBUG
#endif //DBG
#include <cassert>

typedef unsigned int uint;
typedef long long int lli;
typedef unsigned long long int ulli;

#define N 128
#define P ((int)1e9+7)

int c[N];
int b[N];
int s[N];
int dp[N*N];

int main()
{
    int n;
    scanf("%d", &n);
    for(int i=0;i<n;++i) scanf("%d", &c[i]);
    for(int i=0;i<n-1;++i) scanf("%d", &b[i]);
    int q;
    scanf("%d", &q);
    for(int qc=0; qc<q; ++qc)
    {
        int x;
        scanf("%d", &x);
        s[0] = x;
        for(int i=1;i<n;++i) s[i] = s[i-1]+b[i-1];
        memset(dp,0,sizeof(dp));
        dp[0] = 1;
        int tar = 0;
        for(int i=0;i<n;++i)
        {
            for(int j=i*100,ej=std::max(0,tar);j>=ej;--j)if(dp[j])
            {
                for(int k=j+1,ek=j+c[i];k<=ek;++k)
                    dp[k] = (dp[k] + dp[j]) % P;
            }
            tar += s[i];
        }
        int ans = 0;
        for(int i=std::max(0,tar),e=n*100;i<=e;++i)
            ans = (ans + dp[i]) %P;
        printf("%d\n", ans);
    }
    return 0;
}
