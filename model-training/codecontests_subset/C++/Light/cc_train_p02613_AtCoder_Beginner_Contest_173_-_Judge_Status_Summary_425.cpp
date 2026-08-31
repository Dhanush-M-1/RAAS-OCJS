#include<iostream>
#include<map>
using namespace std;


int main(){
	int n;
	
	map<string, int> bag;
	
	string str;
	string labels[] = {"AC", "WA", "TLE", "RE"};
	
	cin >> n;
	while(n--){
		cin >> str;
		bag[str]++;
	}
	
	for(int i=0; i < 4; i++){
		string key = labels[i];
		cout << key << " x " << bag[key] << endl;
	}
}
