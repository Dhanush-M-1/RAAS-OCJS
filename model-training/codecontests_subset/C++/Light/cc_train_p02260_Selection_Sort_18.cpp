#include<bits/stdc++.h>
using namespace std;
int cnt;
void selectionSort(int a[],int n){
  for(int i=0;i<n;++i){
    int min=i;
    for(int j=i;j<n;++j)
      if(a[j]<a[min]) min=j;
    if(min!=i){
      swap(a[i],a[min]);
      cnt++;
    }
  }
}
int main(){
  int n,a[101];
  cin>>n;
  for(int i=0;i<n;++i) cin>>a[i];
  selectionSort(a,n);
  for(int i=0;i<n;++i) cout<<a[i]<<(i==n-1?"\n":" ");
  cout<<cnt<<endl;
  return 0;
}