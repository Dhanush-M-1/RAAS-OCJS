#include <iostream>
using namespace std;
int main(void){
  int n,a[100],min,ans=0;
  cin>>n;
  for(int i=0;i<n;i++)
    cin>>a[i];
  for(int i=0;i<n;i++){
    min=i;
    for(int j=i;j<n;j++){
      if(a[j]<a[min]){
	min=j;
      }
    }
    if(i!=min)
      ans++;
    swap(a[i],a[min]);
  }
  for(int i=0;i<n-1;i++)
    cout<<a[i]<<" ";
  cout<<a[n-1]<<endl;
  cout<<ans<<endl;
  return 0;
}