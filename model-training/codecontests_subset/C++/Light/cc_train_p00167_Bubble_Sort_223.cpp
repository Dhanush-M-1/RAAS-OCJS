#include<iostream>
#include<algorithm>
using namespace std;

int main(){
  int n,res;
  int a[100];

  while(1){
    cin >> n;
    if(!n)break;

    for(int i=0;i<n;i++)cin >> a[i];

    res = 0;
    for(int i=n-1;i>0;i--){
      for(int j=0;j<i;j++){
	if(a[j]>a[j+1]){
	  res++;
	  swap(a[j],a[j+1]);
	}
      }
    }

    cout << res << endl;
  }
}