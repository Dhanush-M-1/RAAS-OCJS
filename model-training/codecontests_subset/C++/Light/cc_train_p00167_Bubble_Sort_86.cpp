#include <iostream>
#include <algorithm>
#include <functional>
#include <vector>
#include <cstdio>
#include <string>
#include <cmath>
#include <cfloat>
#include <map>
#include <queue>
#include <stack>
using namespace std;
int main(){

	int n;
	
	while(cin>>n,n!=0){
		int c=0;
		vector<int> s(n);
		for(int i=0;i<n;i++)
			cin>>s[i];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(s[j]>s[j+1]){
				swap(s[j],s[j+1]);
					c++;
				}
			}
			
		}
		cout<<c<<endl;
	}
	
	
}