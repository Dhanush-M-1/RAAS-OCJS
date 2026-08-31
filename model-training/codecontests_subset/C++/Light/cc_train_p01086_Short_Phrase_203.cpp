#include<iostream>
#include<string.h>
#include<string>
#include<cstdio>
#include<algorithm>
#include<stack>
#include<queue>
#include<vector>
#include<cmath>
#include<utility>
#include<set>
#define ll long long int
#define ld long double
#define INF 1000000000
#define EPS 0.0000000001
#define rep(i,n) for(i=0;i<n;i++)
using namespace std;
typedef pair<int, int> pii;

int main()
{
  int n;
  while(1){ 
    cin>>n;
    if(n==0)break;
    string str;
    int len[45];
    int i,j;
    int ans;

    rep(i,n){
      cin>>str;
      len[i]=str.size();
    }
    rep(i,n){
      int tanku[5]={5,7,5,7,7};
      int now=0;
      for(j=i;j<n;j++){
	if(len[j]>tanku[now])break;
	if(len[j]==tanku[now])now++;
	else tanku[now]-=len[j];
	if(now==5) goto ANS;
      }
    }
  ANS:cout<<i+1<<endl;
  }

}