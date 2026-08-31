#include<iostream>
#include<vector>
using namespace std;
typedef long long ll;

int main(){
    int n,m; cin>>n>>m;
    vector<int> a(n+1,0),dp(n+2,0);
    for(int i=0;i<m;i++){
        int t; cin>>t;
        a[t]=1;
    }
    dp[n]=1;
    for(int i=n-1;i>=0;i--){
        if(a[i]) dp[i]=0;
        else dp[i]=(dp[i+1]+dp[i+2])%1000000007;
    }
    cout<<dp[0]<<endl;
}