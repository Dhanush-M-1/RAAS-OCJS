var uf = new Int32Array(1000000);
uf.fill(-1);

function find(a)
{
  var stack = [];
  while (uf[a] >= 0)
  {
    stack.push(a);
    a = uf[a];
  }
  for (var i=0 ; i<stack.length ; i++)
  {
    uf[stack[i]] = a;
  }
  return a;
}
function merge(a, b)
{
  a = find(a);
  b = find(b);
  
  if (a != b)
  {
    if (uf[a] < uf[b])
    {
      uf[b] = a;
    }
    else if (uf[a] > uf[b])
    {
      uf[a] = b;
    }
    else
    {
      uf[a]--;
      uf[b] = a;
    }
  }
}

(function(){
  function mapInt(x) { return parseInt(x, 10); }

  var nm = readline().split(" ").map(mapInt);
  var perm = new Int32Array(readline().split(" ").map(mapInt));

  var n = nm[0];
  var m = nm[1];

  for (var i=0 ; i<m ; i++)
  {
    var ab = readline().split(" ").map(mapInt);
    merge(ab[0]-1, ab[1]-1);
  }
  
  var map = new Map();
  for (var i=0 ; i<n ; i++)
  {
    var root = find(i);
    if (!map.has(root)) map.set(root, []);
    
    map.get(root).push(i);
  }
  
  var out = new Int32Array(n);
  for (var itr=map.values(), o=itr.next() ; !o.done ; o=itr.next())
  {
    var p = o.value;
    var v = new Int32Array(p);
    for (var i=0 ; i<v.length ; i++)
    {
      v[i] = perm[v[i]];
    }
    v.sort(function(a,b)
    {
      return b - a;
    });
    
    for (var i=0 ; i<v.length ; i++)
    {
      out[p[i]] = v[i];
    }
  }
  
  print(out.join(" "));
})();
