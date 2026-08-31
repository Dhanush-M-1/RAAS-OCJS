#include<iostream>
#include<string>
#include<algorithm>
#include<map>
#include<set>
#include<utility>
#include<vector>
#include<cmath>
#include<cstdio>
#define loop(i,a,b) for(int i=a;i<b;i++) 
#define rep(i,a) loop(i,0,a)
#define pb push_back
#define mp make_pair
#define it ::iterator
#define all(in) in.begin(),in.end()
const double PI=acos(-1);
const double ESP=1e-10;
using namespace std;
int main(){
  int n;
  while(cin>>n,n){
    vector<int>in(n);
    int co=0;
    rep(i,n)cin>>in[i];
    rep(i,n){
      rep(j,n-i-1){
	if(in[j]>in[j+1]){
	  co++;
	  swap(in[j],in[j+1]);
	}
      }
    }
    cout<<co<<endl;
  }
}