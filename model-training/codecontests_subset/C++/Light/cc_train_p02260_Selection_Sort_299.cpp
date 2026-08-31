#include<iostream>

using namespace std;

int n, a[109];

int main(){
  cin >> n;
  for(int i=0;i<n;i++)cin >> a[i];
  int cnt=0;
  for(int i=0;i<n;i++){
    int mni=i;
    for(int j=i;j<n;j++){
      if(a[j]<a[mni]){
        mni=j;
      }
    }
    if(mni!=i){
      cnt++;
      swap(a[mni], a[i]);
    }
  }
  for(int i=0;i<n;i++)cout << a[i] << (i<n-1?' ':'\n');
  cout << cnt << endl;
}
