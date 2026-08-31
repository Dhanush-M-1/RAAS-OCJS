#include<bits/stdc++.h>
using namespace std;
int main(){
  int minj,n,count=0;
  cin >> n;
  vector<int> a(n);
  for(int i=0;i<n;i++)
    cin >> a.at(i);
  
  for(int i=0;i<n;i++){
    minj = i;
    for(int j=i;j<n;j++){
      if(a[j]<a[minj])
        minj = j;
    }
    if(a[i]!=a[minj])
      count++;
    swap(a[i], a[minj]);
  }
  
  for(int k=0;k<n-1;k++)
    cout << a[k] << " ";
  cout << a[n-1] << endl;
  cout << count << endl;
  
  return 0;
}
