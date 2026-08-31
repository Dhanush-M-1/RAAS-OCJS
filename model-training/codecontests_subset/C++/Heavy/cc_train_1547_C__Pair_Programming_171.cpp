//#pragma GCC optimize(1)
//#pragma GCC optimize(2)
//#pragma GCC optimize(3,"Ofast","inline")
# include<iostream>
# include<algorithm>
# include<unordered_map>
# include<cmath>
# include<cstdio>
# include<set>
# include<stack>
# include<queue> 
# include<map>
# include<string>
# include<cstring> 
# include<limits.h>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int > PII; 
const int mod=998244353;
const int MAX=3e6+10;
const int Time=86400;
const int X=131;
const int inf=0x3f3f3f3f;
const double PI = 1e-4;
double pai = 3.14159265358979323846; 

int t,k,n,m;
int a[MAX],b[MAX];

int main(){  
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> t;
    while(t--){
    	queue<int>q;
    	cin >> k >> n >> m;
    	for(int i = 1 ; i <= n ; i ++ ) cin >> a[i];
    	for(int i = 1 ; i <= m ; i ++ ) cin >> b[i];
    	
    	bool flag = true;
    	int i = 1 , j = 1;
    	
    	while( i + j != n + m + 2){
    		  if(a[i] == 0 && i <= n){ 
    		      q.push(a[i]); 
    		   	  i++;
    		   	  k++;
    		   	  continue;
			   }
			   if(b[j] == 0 && j <= m){
			   	  q.push(b[j]);
				  j++;
				  k++;
				  continue; 
			   }
			   if(a[i] <= k && i <= n){
			   	  q.push(a[i]);
			   	  i++;
			   	  continue;
			   }
			   if(b[j] <= k && j <= m){
			   	  q.push(b[j]);
				  j++;
				  continue; 
			   }
			   flag = false;
			   break;
		}
		if(flag){
			    while(!q.empty()){
			    	 cout<<q.front()<<" ";
			    	 q.pop() ;
				}
				cout<<"\n";
		}
		else cout<<"-1\n";
	}
	return 0;
}

