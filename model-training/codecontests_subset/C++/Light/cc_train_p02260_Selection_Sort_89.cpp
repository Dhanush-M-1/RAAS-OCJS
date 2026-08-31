#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  int a[105];
  int minj;
  int co=0;
  cin >> n;
  for(int i=0;i<n;i++){
    cin >> a[i];
  }
  for(int i=0;i<n;i++){
    minj=i;
    for(int j=i;j<n;j++){
      if(a[j]<a[minj])
	minj=j;
    }
    if(i!=minj){
      swap(a[i],a[minj]);
      co++;
    }
  }
  for(int i=0;i<n;i++){
    cout << a[i];
    if(i+1!=n)cout << " ";
  }
  cout << endl;
  cout << co << endl;
  return 0;
}