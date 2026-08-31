#include <iostream>
using namespace std;

int main(){
  int N,A[102];
  int i,j,mini,t,cnt=0;

  cin >> N;
  for (i=0;i<N;i++)cin >> A[i];

  for (i=0;i<N;i++){
    mini=i;
    for (j=i;j<N;j++){
      if (A[mini]>A[j])mini=j;
    }
    if (i!=mini){
      t=A[i];
      A[i]=A[mini];
      A[mini]=t;
      cnt++;
    }
  }

  for (i=0;i<N-1;i++)
    cout << A[i] << " ";

  cout << A[i] << endl;
  cout << cnt << endl;
  
  return 0;
}