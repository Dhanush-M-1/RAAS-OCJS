#include<vector>
#include<list>
#include<algorithm>
#include<iostream>
#include<string>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<cmath>
using namespace std;
int main(){
  int h,i;
  int a[100],n,c;
  for(;;){
    cin>>n;
    if(n==0)
      break;
    for(i=0;i<n;i++)
      cin>>a[i];
    c=0;
    do{
      h=0;
      for(i=1;i<n;i++){
	if(a[i-1]>a[i]){
	  swap(a[i-1],a[i]);
	  h=1;
	  c++;
	}
      }
    }while(h);
    cout<<c<<endl;
  }
  return 0;
}