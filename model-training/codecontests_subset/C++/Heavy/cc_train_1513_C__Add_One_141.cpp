#include <bits/stdc++.h>

#define IO ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
typedef long long ll;
typedef long double ld;
using namespace std;
mt19937 rng((unsigned int) chrono::steady_clock::now().time_since_epoch().count());

const int MOD = 1e9 + 7;

template<typename T, typename U>
pair<T, U> operator+(const std::pair<T, U> &l, const std::pair<T, U> &r) {
    return {l.first + r.first, l.second + r.second};
}

template<typename T, typename U>
pair<T, U> operator-(const std::pair<T, U> &l, const std::pair<T, U> &r) {
    return {l.first - r.first, l.second - r.second};
}
const int N =2e5 + 10;
int dp[N][10];
int solve(int num , int m){
    if(dp[m][num]!=-1){
        return dp[m][num];
    }
    if(m==0){
        return 1;
    }
    num++;
    ll ans = 0;
    if(num==10){
        ans+=solve(1,m-1);
        ans+=solve(0,m-1);
        ans%=MOD;
    }else{
        ans=solve(num,m-1);
    }
    return dp[m][num-1] = ans;
}
int main() {
    IO;
    int t;
    cin>>t;
    memset(dp,-1,sizeof dp);
    while (t--){
        string str;
        cin>>str;
        int m ;
        cin>>m ;
        ll ans = 0 ;
        for(char ch : str){
            ans+=solve(ch-'0',m);
            ans%=MOD;
        }
        cout<<ans<<endl;

    }
}