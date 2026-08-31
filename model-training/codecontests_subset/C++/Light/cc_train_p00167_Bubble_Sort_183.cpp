#include<iostream>
using namespace std;
int main(){
  int t,n;
  long long int bell[100],tmp;
  while(1){
    t=0;

    cin >> n;
    if(n==0){
      break;
    }
    for(int i=0;i<n;i++){
      cin >> bell[i];
    }
    for(int i=0;i<n-1;i++){
      for(int j=n-1;j>i;j--){
	if(bell[j]<bell[j-1]){
	  tmp=bell[j];
	  bell[j]=bell[j-1];
	  bell[j-1]=tmp;
	  t++;
	}
      }
    }
    cout << t << endl;
  }
}