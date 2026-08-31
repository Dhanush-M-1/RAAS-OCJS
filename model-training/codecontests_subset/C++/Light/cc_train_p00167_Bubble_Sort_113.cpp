#include<iostream>
using namespace std;

int main(){
  int n;
  while(cin >> n, n) {
    int cnt = 0, a, num[101];
    for(int i = 0 ; i < n ; i++) cin >> num[i];
    
    for(int i = 0 ; i < n-1 ; i++) {
      for(int j = n-1 ; j > i ; j--) {
	if(num[j-1] > num[j]) {
	  a = num[j-1];
	  num[j-1] = num[j];
	  num[j] = a;
	  cnt++;
	}
      }
    }
    cout << cnt << endl;
  }
}