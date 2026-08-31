#include <bits/stdc++.h>
using namespace std;
const long long N=1e9+7;
#define int long long 
#define pb push_back
#define f first
#define si second
#define mp make_pair
#define fastrack ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define endl "\n"
#define PI 3.1415926535897
string alp="abcdefghijklmnopqrstuvwxyz";
signed main(){
fastrack;
int test=1;
cin>>test;
map<int,int>m[2];
int d[2][200007];
for(int i=0;i<2;i++){
    for(int j=0;j<200007;j++){
        d[i][j]=0;
    }
}
for(int i=0;i<2;i++){
    for(int j=0;j<10-i;j++){
        d[i][j]=1;
    }
    m[i][10-i]=1;
    d[i][10-i]=2;
    for(int j=11-i;j<200007;j++){
        d[i][j]+=(d[i][j-1]%N+m[i][j-9]%N+m[i][j-10]%N)%N;
        d[i][j]%=N;
        m[i][j]=N+(d[i][j])-(d[i][j-1]);
        m[i][j]%=N;
    }
}//cout<<d[9][200000]<<endl;
while(test--){
int n,m,x,ans=0;
cin>>n>>m;
int c[10]={};
while(n>0){
    x=n%10;
    c[x]++;
    n/=10;
}
for(int i=0;i<10;i++){
    if(i==0||i==1){
        ans+=(c[i]*d[i][m])%N;
        ans%=N;
    }
    else{
        if(m>=10-i){
            ans+=(c[i]*d[0][m-10+i])%N;
            ans%=N;
            ans+=(c[i]*d[1][m-10+i])%N;
            ans%=N;
        }
        else if(c[i]){
            ans+=c[i];
            ans%=N;
        }
    }
    //cout<<ans<<" ";
}//cout<<endl;
cout<<ans<<endl;
}
}
