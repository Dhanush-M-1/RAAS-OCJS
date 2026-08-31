#include<iostream>
#include<algorithm>
#include<set>

using namespace std;

struct S{
  int g[4][4];
  int y,x;
  bool operator<(S s)const{
    return lexicographical_compare(g[0],g[4],s.g[0],s.g[4]);
  }
};

int main(){
  for(int N;cin>>N,N;){
    set<S> d[366];
    S s{{},1,1};
    d[0].insert(s);
    for(int i=0;i<N;i++){
      int s[16];
      for(int j=0;j<16;j++){
	cin>>s[j];
      }
      for(auto e:d[i]){
	for(int k=0;k<3;k++){
	  for(int l=0;l<3;l++){
	    if(k!=e.y&&l!=e.x||i==0&&(k!=1||l!=1))continue;
	    auto cs=e;
	    cs.y=k;
	    cs.x=l;
	    for(int m=0;m<4;m++){
	      for(int n=0;n<4;n++){
		cs.g[m][n]++;
	      }
	    }
	    for(int m=0;m<2;m++){
	      for(int n=0;n<2;n++){
		int y=k+m;
		int x=l+n;
		cs.g[y][x]=0;
		if(s[y*4+x])goto next;
	      }
	    }
	    if(*max_element(cs.g[0],cs.g[4])>=7)goto next;
	    d[i+1].insert(cs);
	  next:
	    ;
	  }
	}
      }
    }
    cout<<!d[N].empty()<<endl;
  }
}

      