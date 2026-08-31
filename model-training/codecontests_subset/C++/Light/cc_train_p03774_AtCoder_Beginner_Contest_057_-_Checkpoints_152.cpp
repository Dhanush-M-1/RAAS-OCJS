#include <bits/stdc++.h>
using namespace std;
#define REP(i,n) for(int(i)=0;i<(n);i++)

int main(){
  int n,m;cin>>n>>m;
  vector<int> ax(n,0),ay(n,0),cx(m,0),cy(m,0);
  REP(i,n) cin>>ax.at(i)>>ay.at(i);
  REP(i,m) cin>>cx.at(i)>>cy.at(i);

  REP(i,n){
    int num=0,dist=1e9;
    REP(j,m){
      if(dist>abs(ax.at(i)-cx.at(j))+abs(ay.at(i)-cy.at(j))){
        dist=abs(ax.at(i)-cx.at(j))+abs(ay.at(i)-cy.at(j));
        num=j+1;
      }
    }
    cout<<num<<endl;
  }
}