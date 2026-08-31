#include <stdio.h>
#include <set>
#include <math.h>
#include <algorithm>
using namespace std;

int maxNum(int N){
  int maxInt=0,i=1,a,b;
  int lenN=(int)log10(N)+1;
  while (i<lenN){
    a=N/(int)pow(10.0,(double)lenN-i);
    b=N%(int)pow(10.0,(double)lenN-i);
    maxInt=max(maxInt,a*b);
    i++;
  }
  return maxInt;
}

int main(){
  int Q,cnt,N;
  scanf("%d",&Q);
  for (int i=0;i<Q;i++){
    set<int> S;
    scanf("%d",&N);
    cnt=0;
    while (true){
      set<int>::iterator iti=S.find(N);
      if (N<10){
        printf("%d\n",cnt);
        break;
      }else if (iti!=S.end()){
        printf("-1\n");
        break;
      }else{
        S.insert(N);
        N=maxNum(N);
        cnt++;
      }
    }
  }
  return 0;
}