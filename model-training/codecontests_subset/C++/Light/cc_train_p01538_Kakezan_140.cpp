//46
#include<iostream>
#include<set>

using namespace std;

int main(){
  int q;
  cin>>q;
  while(q--){
    int n;
    cin>>n;
    int a;
    set<int> s;
    for(a=0;n>=10&&s.insert(n).second;a++){
      int m=0;
      for(int p=10;p<=n;p*=10){
	int h,l;
	h=n/p;
	l=n-h*p;
	if(m<h*l){
	  m=h*l;
	}
      }
      n=m;
    }
    cout<<((n<10)?a:-1)<<endl;
  }
  return 0;
}
	  