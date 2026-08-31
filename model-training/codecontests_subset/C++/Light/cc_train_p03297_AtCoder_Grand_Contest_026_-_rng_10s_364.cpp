#include <bits/stdc++.h>
using namespace std;
typedef long long i64;
int T; i64 A, B, C, D, g; i64 gcd(i64 a, i64 b) { return b?gcd(b, a%b):a; }
int main()
{
    for(scanf("%d", &T); T--; )
    {
        scanf("%lld%lld%lld%lld", &A, &B, &C, &D);
        if(A < B||D < B) puts("No");
        else if(B <= C+1) puts("Yes");
        else g = gcd(B, D), puts((A-B)/g == (A-C-1)/g?"Yes":"No");
    }
    return 0;
}