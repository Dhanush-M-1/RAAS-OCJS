#include <iostream>
using namespace std;
int main(){
  int n;
  int a[1000];
  while( cin >> n,n){
    for(int i = 0 ; i < n ; i++ )cin >> a[i];
    int ans = 0;
    for(int i = n-1 ; i >= 0 ; i-- ){
      for(int j = 0 ; j < n - 1 ; j++  ){
	if(a[j] > a[j + 1]){
	  swap(a[j],a[j + 1]);
	  ans++; 
	}
      }
    }
    cout << ans << endl;
  }  
  return 0;
}