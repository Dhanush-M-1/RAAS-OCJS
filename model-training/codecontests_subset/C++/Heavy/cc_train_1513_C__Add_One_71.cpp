#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#include<cstdio>
#include<cmath>
#include<map>
#include<set>
#include<queue>
#include<stack>
#include<bitset>
#include<cstdlib>
#include <iomanip>
#include<climits>
#include<fstream>
 
using namespace std;
 
//=========================MACROS====================================
#define GSK ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define int long long
#define ll long long
#define fo(i,n) for(int i=0;i<(n);i++)
#define pb	push_back
#define mp	make_pair
#define F 	first
#define S 	second
#define all(x) x.begin(), x.end()
#define clr(x) memset(x, 0, sizeof(x))
#define PI 3.1415926535897932384626
#define mod 1000000007;
#define print2(a,b) cout<<#a<<"="<<(a)<<" "<<#b<<"="<<(b)<<endl;
#define print3(a,b,c) cout<<#a<<"="<<(a)<<" "<<#b<<"="<<(b)<<" "<<#c<<"="<<(c)<<endl;
#define endl "\n"
#define runtime() ((double)clock() / CLOCKS_PER_SEC) 
//========================TypeDefs===================================
typedef vector<int>	vi;
typedef vector<bool> vb;
typedef pair<int,int> ii;
typedef vector<ii> vii;
//======================== JFF ==================================

//void* memset( void* str, int ch, size_t n);

// bool isprime(int n){
// 	for(int i=2;i<=sqrt(n);i++){
// 		if(n%i==0) return false;
// 	}
// 	return true;
// }
// const int N=1e6+1;
// bool prime[N];
// void SieveOfEratosthenes(int n)
// {
//     // Create a boolean array
//     // "prime[0..n]" and initialize
//     // all entries it as true.
//     // A value in prime[i] will
//     // finally be false if i is
//     // Not a prime, else true.
    
//     memset(prime, true, sizeof(prime));
 
//     for (int p = 2; p * p <= n; p++)
//     {
//         // If prime[p] is not changed,
//         // then it is a prime
//         if (prime[p] == true)
//         {
//             // Update all multiples
//             // of p greater than or
//             // equal to the square of it
//             // numbers which are multiple
//             // of p and are less than p^2
//             // are already been marked.
//             for (int i = p * p; i <= n; i += p)
//                 prime[i] = false;
//         }
//     }
 
//     // Print all prime numbers
//     // for (int p = 2; p <= n; p++)
//     //     if (prime[p])
//     //         cout << p << " ";
// }
// inline ll power(ll x, ll y, ll p = mod)
// {
//     ll res = 1;
//     x = x % p;
//     while (y > 0)
//     {
//         if (y & 1)
//             res = (res * x) % p;
//         y = y >> 1;
//         x = (x * x) % p;
//     }
//     return res;
// }
 
// inline ll modadd(ll a, ll b, ll m = mod)
// {
//     a += b;
//     if (a >= m)
//         a -= m;
//     return a;
// }
 
// inline ll modmul(ll a, ll b, ll m = mod)
// {
//     return ((a % m) * (b % m)) % m;
// }
 
// inline ll modi(ll a, ll m = mod) { return power(a, m - 2, m); }
 
// long long int inverse(long long int i,ll m=mod){
//     if(i==1) return 1;
//     return (m - ((m/i)*inverse(m%i))%m+m)%m;
// }


void hehe(bool ok){
    cout<<(ok?"YES":"NO")<<endl;
}
int foo(int a,int b){
    return b*((a+b-1)/b)-a;
}
//======================== JFF ==================================
const int M=200015;
int pre[M];

void q1(){
    int n,m;
    cin>>n>>m;
    vi a;
    while(n>0){
        a.pb(n%10);
        n/=10;
    }
    int ans=0;
    for(int x: a){
        ans=(ans+pre[x+m])%mod;
    }
    cout<<ans<<endl;
}
/*
1
2 1 1 3
*/

int32_t main()
{
	GSK;
    // fo(i,N) fac[i]=1;
    // for(int i=1;i<N;i++){
    //     fac[i]=(fac[i-1]*i)%mod;
    // }
    fo(i,10) pre[i]=1;
    for(int i=10;i<M;i++){
        pre[i]=(pre[i-10]+pre[i-9])%mod;
    }
	int cases=1;
	cin >> cases;
    for(int t_case=1;t_case<=cases;t_case++)
	{
		// cout<<"Case #"<<t_case<<": ";
		q1();
	}
    //cerr<<runtime();
	return 0;
}
