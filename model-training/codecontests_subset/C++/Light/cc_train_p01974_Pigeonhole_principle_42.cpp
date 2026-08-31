#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;
typedef long long lint;
typedef vector<int>vi;
typedef pair<int,int>pii;
#define rep(i,n)for(int i=0;i<(int)(n);++i)

int main(){
  int n;
  cin>>n;
  vi a(n);
  rep(i,n)cin>>a[i];
  rep(i,n){
    rep(j,i){
      if((a[j]-a[i])%(n-1)==0){
	cout<<a[i]<<" "<<a[j]<<endl;
	return 0;
      }
    }
  }
}

