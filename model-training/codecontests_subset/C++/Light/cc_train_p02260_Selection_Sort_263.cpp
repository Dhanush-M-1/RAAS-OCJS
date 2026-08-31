#include <bits/stdc++.h>
using namespace std;
 
int main() {
int n,minj,counter=0;
cin>>n;
vector<int> vec(n);

for(int i=0;i<n;i++){
	cin>>vec[i];
}

for(int i =0;i<n;i++){
	minj =i;
	for(int j=i;j<n;j++){
		if(vec[j]<vec[minj]){
		minj =j;
		}
	}
  if(i != minj) counter++;
  	int temp = vec[i];
	vec[i]=vec[minj];
	vec[minj]=temp;
}

for(int i=0;i<n;i++){
	cout<<vec[i];
	if(i!=n-1) cout<<" ";
}
cout<<endl;
cout<<counter<<endl;

}
