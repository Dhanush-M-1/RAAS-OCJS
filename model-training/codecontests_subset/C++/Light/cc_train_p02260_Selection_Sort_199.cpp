#include <iostream>
using namespace std;

int main()
{
  int n;
  cin>>n;
  int A[n];
  int count =0;
  for(int i=0;i<n;i++)
    cin>>A[i];

  for(int i=0;i<n;i++)
    {
      int mini =i;
      for(int j=i;j < n; j++)
	{
	  if(A[j]<A[mini])
	    mini=j;
	}
	    
	  swap(A[i],A[mini]);
	  if(i!=mini)
	    count++;

    }

   for(int i=0;i<n;i++)
     {
       cout<<A[i];
       if(i==n-1)
	 cout<<endl;
       else
	 cout<<" ";
     }
   cout<<count<<endl;
}