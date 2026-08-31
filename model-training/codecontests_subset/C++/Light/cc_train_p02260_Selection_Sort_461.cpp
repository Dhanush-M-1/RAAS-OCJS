#include <iostream>
using namespace std;

int main(void){
  int n, a[100];
  int swpCnt=0;
  cin >> n;
  for (int i=0; i<n; i++) cin >> a[i];

  for (int i=0; i<n; i++){
    int mnj=i, tmp;
    for (int j=i; j<n; j++){
      if (a[j]<a[mnj]) mnj = j;
    }
    if (mnj==i) continue;
    swpCnt++;
    tmp = a[i]; a[i] = a[mnj]; a[mnj] = tmp;
  }
  for (int i=0; i<n-1; i++) cout << a[i] << " ";
  cout << a[n-1] << endl;
  cout << swpCnt << endl;
  return 0;
}

