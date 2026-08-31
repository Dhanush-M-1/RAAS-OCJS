#include <bits/stdc++.h>
using namespace std;

int a[1000001];

void bubble(int *a,int n,int count){
  int ans = count;
  for(int i = 1; i < n; i++){
    if(a[i] < a[i-1]){
      swap(a[i],a[i-1]); count++;
    }
  }
  if(ans != count) bubble(a,n,count);
  else if (ans == count){
    cout << ans << endl;
    return;
  }
}

int main(){
  while(1){
    int n;
    cin >> n; if(n == 0)break;

    for(int i = 0; i < n; i++){
      cin >> a[i];
    }

    int count = 0;
    bubble(a,n,count);

    }
    return 0;
}

