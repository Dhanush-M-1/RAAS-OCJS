#include<iostream>
using namespace std; 
int main (){
  int n,i,a[110],temp,count=0,j;
  while(1){
    count=0;
    cin >> n;
    if(n==0)break;
    for(i=0;i<n;i++){
      cin >> a[i];
    }
    for(i=0;i<n;i++){
      for(j=n-1;j>i;j--){
	if(a[j-1]>a[j]){
	  temp=a[j];
	  a[j]=a[j-1];
	  a[j-1]=temp;
	  count++;
	}
      }
    }
    cout << count << endl;
  }
}