#include<bits/stdc++.h>
using namespace std;
using ll = long long;
using P = pair<int,int>;
#define enld '\n'
#define rep(i,n) for(int i=0; i<(n); i++)
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("Ofast")
constexpr ll INF = 1e18;
constexpr int inf = 1e9;
constexpr ll mod = 1000000007;
constexpr ll mod2 = 998244353;
const double PI = 3.1415926535897932384626433832795028841971;
const int dx[6] = {1, 0, -1, 0,1,1};
const int dy[6] = {0, 1, 0, -1,1,-1};
template<class T> inline bool chmax(T& a, T b) { if (a < b) { a = b; return 1; } return 0; }
template<class T> inline bool chmin(T& a, T b) { if (a > b) { a = b; return 1; } return 0; }
// ---------------------------------------------------------------------------

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    vector<int> A(N);
    rep(i,N) cin >> A[i];
    for(int i=0; i<N; i++){
        for(int j=i+1; j<N; j++){
            if(abs(A[i]-A[j])%(N-1) == 0){
                cout << A[i] << " " << A[j] << "\n";
                return 0;
            }
        }
    }


    return 0;
}
