#include<iostream>
using namespace std;
int main()
{
  int n;
  for(;cin>>n,n;)
    {
      bool l=false,r=false;
      bool next=true;
      int cnt=0;
      for(int i=0;i<n;i++)
	{
	  string str;
	  cin>>str;

	  if(str=="lu")
	    l=true;
	  if(str=="ru")
	    r=true;
	  if(str=="ld")
	    l=false;
	  if(str=="rd")
	    r=false;
	  if(next==l && next==r)
	    {
	      cnt++;
	      next=!next;
	    }
	}
    cout<<cnt<<endl;
    }
}