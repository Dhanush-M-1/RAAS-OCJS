#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t ;
	cin>>t;
	while(t -- ) 
	{
		int k ,  n, m ;
		cin>>k >> n >> m ;
		vector<int>a(n + 1 ) ;
		vector<int>b(m + 1 ) ;
		vector<int>all(m + n + 1 ) ;
		for(int i = 0 ; i <n ; i ++ ) cin>>a[i] ;
		for(int i = 0 ; i < m ; i ++ ) cin>>b[i] ;
		
		int i = 0  , j = 0 , ok = 1 , co = 0 ; 
		while(i < n || j < m ) 
		{
			if(a[i] <= k && i < n ) 
			{
				all[++co] = a[i ] ;
				if(a[i] == 0 ) k ++ ; 
				i ++ ;
			}
			else if(b[j] <=k && j < m ) 
			{
				all[++co] = b[j] ;
				if(b[j] == 0 ) k ++ ;
				j ++ ;
			}
			else 
			{
				ok = 0 ;
				break;
			}
		}
		if(ok == 0 ) cout<<"-1"<<endl;
		else 
		{
			for(int i = 1 ; i <= n + m ; i ++ ) cout<<all[i] <<" " ;
			cout<<endl; 
		}
		
	}
	return 0 ;
}