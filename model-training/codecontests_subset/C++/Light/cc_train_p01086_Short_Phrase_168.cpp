#include<bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  int len[101];
  string s;
  int num[5]={5,7,5,7,7};

  while(1){
    cin>>n;
    if(n==0)break;
    for(int i=0;i<n;i++){
      cin>>s;
      len[i]=s.length();
    }

    int ans=0;
    for(int i=0;i<n;i++){
      int sum=0,c=0;
      for(int j=i;j<n;j++){
	sum+=len[j];
	if(sum==num[c]){
	  sum=0;
	  c++;
	}
	else if(num[c]<sum)break;
	if(c==5)break;
      }
      if(c==5){
	ans=i;
	break;
      }
    }
    cout<<ans+1<<endl;
  }

  return 0;
}