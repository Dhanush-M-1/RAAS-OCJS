#include<bits/stdc++.h>
using namespace std;
#define inf 1e9
#define ll long long
#define ull unsigned long long
#define M 1000000007
#define P pair<int,int>
#define PLL pair<ll,ll>
#define FOR(i,m,n) for(int i=m;i<n;i++)
#define RFOR(i,m,n) for(int i=m;i>=n;i--)
#define rep(i,n) FOR(i,0,n)
#define rrep(i,n) RFOR(i,n,0)
#define all(a) a.begin(),a.end()
const int vx[4] = {0,1,0,-1};
const int vy[4] = {1,0,-1,0};
#define PI 3.14159265

int a[10]={5,7,5,7,7};

void f(int n){
  string s[100];
  rep(i,n){
    cin>>s[i];
  }

  rep(i,n){
    int k=0;
    int t=0;
    FOR(j,i,n){
      t+=s[j].length();
      if(t==a[k]){
        k++;
        t=0;
      }
    }
    if(k==5){
      cout<<i+1<<endl;
      return;
    }
  }
}



int main(){
  int n;
  while(1){
    cin>>n;
    if(n==0) break;
    f(n);
  }

  return 0;
}
