#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long ll;

int T;

ll A, B, C, D;

ll gcd(ll a, ll b) {
    return !b ? a : gcd(b, a % b);
}

int main() {
    scanf("%d", &T);
    while(T--) {
        scanf("%lld%lld%lld%lld", &A, &B, &C, &D);
        ll g = gcd(B, D);
        if(A < B || B > D || B - g + A % g > C) puts("No"); else puts("Yes");
    }
}