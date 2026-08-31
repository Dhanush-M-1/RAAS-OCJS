#include<bits/stdc++.h>

using namespace std;

int main(){
  int n,cnt;
  int a[101] = {};
  while(1){
    cin >> n;
    if(n == 0)break;
    cnt = 0;
    for(int i=0;i<n;i++){
      cin >>a[i];
    }
    for(int j=0;j<n;j++)
      for(int i=0;i<n-1;i++){
	if(a[i] > a[i+1]){swap(a[i],a[i+1]);
	  cnt++;}
      }

    
    cout << cnt << endl;
      }

  }

