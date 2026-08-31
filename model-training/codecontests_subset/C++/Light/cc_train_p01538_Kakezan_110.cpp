#include<iostream>
using namespace std;

int main(){
  int q,n,c;
  cin >> q;
  while(q--){
    cin >> n; c=0;
    for(;;){
      int m = -1,k = 10;
      if(n<10){
	cout << c << endl;
	break;
      }
      for(int i=0;i<5;i++){
	m=max(m,(n/k)*(n%k));
	k*=10;
      }
      n = m; c++;
    }
  }
}