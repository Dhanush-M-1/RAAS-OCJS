#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
  while(1){
    int n;
    cin>>n;
    if(!n)break;
    vector<int> a(n);
    for(int i=0;i<n;++i)
      cin>>a[i];
    int cnt=0;
    for(int i=0;i<n;++i)
      for(int j=0;j<n-1;++j)
        if(a[j]>a[j+1]){
          swap(a[j],a[j+1]);
          ++cnt;
        }
    cout<<cnt<<endl;
  }
  return 0;
}