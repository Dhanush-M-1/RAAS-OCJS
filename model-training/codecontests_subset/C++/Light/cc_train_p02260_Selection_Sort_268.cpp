#include<bits/stdc++.h>
using namespace std;
int main(){
    int k,n,a[101],v,j,t=0;
    cin>>n;
    for (int i=0; i<n; i++)
        cin>>a[i];
    for (int i=0; i<n; i++){
    	k=i;
    	for (int j=i+1; j<n; j++)
    		if (a[j]<a[k])
    		   k=j;
        if (a[k]<a[i]){
        	t++;
        	v=a[k];
        	a[k]=a[i];
        	a[i]=v;
		}
		
	}
	cout<<a[0];
	for (int i=1; i<n; i++)
	    cout<<' '<<a[i];
	cout<<endl;
	cout<<t<<endl;
    return 0;
} 
