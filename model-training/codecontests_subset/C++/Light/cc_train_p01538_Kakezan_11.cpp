#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int q, n;

int keta(int n){
  int count=1;
  while (1){
    if (n>=10){
      count++;
      n = n/10;
    }
    else break;
  }
  return count;
}

int maain(){
  cin >> q;
  for (int i=0;i<q;i++){
    cin >> n;
    cout << keta(n) << endl;
  }
  return 0;
}

int main(){
  int a,b;
  cin >> q;
  for (int i=0;i<q;i++){
    cin >> n;
    int ans=0;
    while (n>=10){
      int max=0;
      int ket=keta(n);
      for (int j=1;j<ket;j++){
	a=n/pow(10,j);
	b=n-a*pow(10,j);
	if (a*b>max) max=a*b;
      }
      n=max;
      ans++;
    }
    cout << ans << endl;
  }
  return 0; 
}