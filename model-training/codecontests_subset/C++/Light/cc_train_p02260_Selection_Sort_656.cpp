#include <iostream>
#include <utility>

using namespace std;

int main(){
  int cnt=0;
  int n; cin >> n;
  int a[n];
  for(int i=0;i<n;i++) cin >> a[i];
  for(int i=0;i<n;i++){
    int minj=i;
    for(int j=i;j<n;j++){
      if(a[j]<a[minj]) minj=j;
    }
    if(i!=minj) cnt++;
    swap(a[i],a[minj]);
  }
  for(int i=0;i<n;i++){
    if(i==n-1) cout << a[n-1] << endl;
    else cout << a[i] << " ";
  }
  cout << cnt << endl;
}