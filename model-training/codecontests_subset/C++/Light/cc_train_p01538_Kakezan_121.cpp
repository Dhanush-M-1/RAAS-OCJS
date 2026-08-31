#include<iostream>
#include<map>
using namespace std;

int main(){
  map<int,bool> h;
  int q,n,cnt;
  cin >> q;
  while(q--){
    cin >> n;
    cnt = 0;
    h.clear();
    for(;;){
      int m = -1, k = 10;
      if(h[n]){
	cout << -1 << endl;
	break;
      }
      h[n] = true;
      if(n<10){
	cout << cnt << endl;
	break;
      }
      for(int i=0;i<5;i++){
	m = max(m,(n/k)*(n%k));
	k *= 10;
      }
      n = m; cnt++;
    }
  }
}