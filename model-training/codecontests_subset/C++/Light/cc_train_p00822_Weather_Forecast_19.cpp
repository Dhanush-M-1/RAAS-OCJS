#include<iostream>
#include<vector>
#include<array>
#include<set>

using namespace std;

struct S{
  int y,x;
  array<array<int,4>,4> b;
  bool operator<(S s)const{
    return (y!=s.y)?y<s.y:(x!=s.x)?x<s.x:b<s.b;
  }
};

int main(){
  for(int N;cin>>N,N;){
    set<S> v[366];
    v[0].insert({1,1,{}});
    for(int i=0;i<N;i++){
      int s[4][4];
      for(int j=0;j<4;j++){
	for(int k=0;k<4;k++){
	  cin>>s[j][k];
	}
      }
      for(auto &e:v[i]){
	for(int j=0;j<3;j++){
	  for(int k=0;k<3;k++){
	    if(i==0&&(j!=1||k!=1))continue;
	    if(e.y!=j&&e.x!=k)continue;
	    auto n=e.b;
	    bool fail=false;
	    for(int l=0;l<2;l++){
	      for(int m=0;m<2;m++){
		fail|=s[j+l][k+m];
		n[j+l][k+m]=-1;
	      }
	    }
	    for(auto &f:n){
	      for(auto &g:f){
		fail|=++g>=7;
	      }
	    }
	    if(!fail){
	      v[i+1].insert({j,k,n});
	    }
	  }
	}
      }
    }
    cout<<!v[N].empty()<<endl;
  }
}