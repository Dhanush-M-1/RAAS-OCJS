#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int,int> pi;
typedef pair<ll,pi> pii;
typedef vector<int> vi;

#define f first
#define s second
#define all(x) (x).begin(), (x).end()
#define pb push_back
#define mp make_pair
#define forn(i, n) for(register int i=0; i<n; i++)
#define Forn(i, n) for(register int i=1; i<=n; i++)
#define foreach(it, a) for(__typeof((a).begin()) it=(a).begin(); it!=(a).end(); it++)
#define Foreach(it, a) for(__typeof((a).rbegin()) it=(a).rbegin(); it!=(a).rend(); it++)
#define INF 1999999999999999999LL

inline int in()
{
    char c=getchar();
    int neg=1, x=0;
    while(!isdigit(c)) (c=='-')?neg=-1, c=getchar():c=getchar();
    while(isdigit(c)) x=(x<<3)+(x<<1)+(c^48), c=getchar();
    return neg*x;
}

const int MAX=2e5+5;

int N;
ll dpl[MAX], dpr[MAX], A[MAX], D, ret;

int main()
{
    N=in(), D=in();
    forn(i, N)
        A[i]=in(), ret+=A[i];
    ret+=(N-1)*D;
    dpr[0]=A[0];
    Forn(i, N-1)
        dpr[i]=min(dpr[i-1]+D, A[i]);
    dpl[N-1]=A[N-1];
    for(int i=N-2; i>-1; i--)
        dpl[i]=min(dpl[i+1]+D, A[i]);
    Forn(i, N-2)
        ret+=min(dpl[i], dpr[i]);
    printf("%lld\n", ret);
    return 0;
}