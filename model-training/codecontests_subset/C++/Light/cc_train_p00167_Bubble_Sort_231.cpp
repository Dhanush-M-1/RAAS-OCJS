#include<iostream>
using namespace std;
int main() {
  int n,c,s;
  while(cin>>n){
    if(n==0) break;
    int a[n];
    for(c=0;c<n;c++) cin>>a[c];
    c=0;
    for(int i=0; i<n; i++)
      for(int j=0; j<n-i-1; j++)
	if(a[j] > a[j+1])s=a[j+1],a[j+1]=a[j],a[j]=s,c++;
    cout<<c<<"\n";
  }
}