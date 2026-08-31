#include<bits/stdc++.h>
#define rep(i,n) for(int i=0; i<n; i++)
using namespace std;

int main(){
  int N,M; 
  cin >>N>>M;
  
  int a[N],b[N];
  rep(i,N) cin >>a[i]>>b[i];
  
  int c[M], d[M];
  rep(i,M) cin >>c[i]>>d[i];

  int ans;
  rep(i,N){
    int mnD = abs(a[i]-c[0]) + abs(b[i]-d[0]);
    ans = 1;
    rep(j,M){
      int D = abs(a[i]-c[j]) + abs(b[i]-d[j]);
      if(D<mnD){
        ans = j+1;
        mnD = D;
      }
    }
    cout <<ans<< endl;
  } 
}