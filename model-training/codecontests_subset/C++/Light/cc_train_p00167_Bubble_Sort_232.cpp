#include<iostream>
using namespace std;

int main(){

  int n;

  while(cin >> n, n){

    int a[1000],tmp,count = 0;

    for(int i=0;i<n;i++) cin >> a[i];

    for(int i=0;i<n-1;i++){
      for(int j=n-1;j>i;j--){
	if(a[j] < a[j-1]){

	  tmp = a[j];
	  a[j] = a[j-1];
	  a[j-1] = tmp;

	  count++;

	}
      }
    }

    cout << count << endl;

  }
}